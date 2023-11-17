import { Component, Input ,Output, EventEmitter, SimpleChanges} from '@angular/core';
import { Student } from '../model/Student/student.model';
import { HttpServerService } from '../Services/http-server.service';
import { Pagination } from '../model/Pagination/pagination.model';
import { JWT } from '../model/JWT/jwt.model';
import { DataServiceService } from '../Services/data-service.service';
import { User } from '../model/User/user.model';
import { Router } from '@angular/router';
@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})

export class HomePageComponent {
  @Input() pag: number =1;
  searchName = '';
  hidPre = false;
  hidNext = false;
  author = true;
  limit: number =5;
  totalPage :Array<number>=[];
  listUser =  new Array<Student>;
  pageFomat = new Pagination([],0);
  jwt:JWT = new JWT(new User('','',[],false,false,false,false),'');
  constructor(private httpService : HttpServerService, private data : DataServiceService, private route : Router) {
    this.data.currentMessage.subscribe(message => {
      this.jwt = message;
      let token:any = localStorage.getItem('jwt');  
      if(token == '' || token == 'undefined' || token == null){  
        localStorage.setItem('jwt',this.jwt.jwt) ;
        localStorage.setItem('author',this.jwt.user.authorities[0].authority)
        token = localStorage.getItem('jwt');  
      }
      this.jwt = new JWT(new User('','',[],false,false,false,false),token);
    });
  }
  public ngOnInit():void{
    this.fetch(this.pag,this.searchName);
  }

  fetch(page:number, name:string){
    this.totalPage = [];
    if(name==''){
      this.httpService.getStudent(this.jwt.jwt,page,this.limit).subscribe( data=>{ 
        this.pageFomat = data;
        this.author = localStorage.getItem('author') != 'admin'
        this.listUser = this.pageFomat.content ;
        this.clickPage(this.pag,this.pageFomat.totalPage)
        for(let i=0 ;i< this.pageFomat.totalPage ;i++){
          this.totalPage.push(i+1);
        }
      })
    }
    else{
      this.httpService.searchStudent(this.jwt.jwt,name,page,this.limit).subscribe( data=>{ 
        this.pageFomat = data;
        this.listUser = this.pageFomat.content ;
        console.log(this.pageFomat.totalPage + " "+ this.pag)
        // console.log(this.listUser)
        this.clickPage(this.pag, this.pageFomat.totalPage)
        for(let i=0 ;i< this.pageFomat.totalPage ;i++){
          this.totalPage.push(i+1);
        }
      }
      )
    }
  }

  clickPage(page:number, total: number){
    if(total == 0){
      this.hidPre = true
      this.hidNext = true
    }else{
      if(page < 2){
        this.hidPre = true;
      }else{
        this.hidPre = false;
      }
      if(page < this.pageFomat.totalPage){
        this.hidNext = false;
      }else{
        this.hidNext = true;
      }
    }
   
  }

  updateStudent(id:number, ten:string, sdt:string, diachi:string){
    this.data.changMessageUpdate(new Student(id,ten,sdt,diachi));
    this.route.navigateByUrl('create');
  }

  deleteStudent(user:Student){
    this.httpService.deleteStudent(user.id,this.jwt.jwt).subscribe(data=>{
      this.fetch(this.pag,this.searchName);
    });
  }

  redirectCreate(){
    this.data.changMessageUpdate(new Student(0,'','',''));
    this.route.navigateByUrl('create');
  }

  getPage(page:number){
    this.pag = page;
    this.fetch(page,this.searchName);
  }

  searchStudents(name:string){
    this.searchName = name;
    this.fetch(this.pag,this.searchName)
  }

  logOut(){
    localStorage.removeItem('jwt')
    localStorage.removeItem('author')
  }
}

