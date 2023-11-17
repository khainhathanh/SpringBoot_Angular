import { Component } from '@angular/core';
import { HttpServerService } from '../Services/http-server.service';
import { DataServiceService } from '../Services/data-service.service';
import { JWT } from '../model/JWT/jwt.model';
import { User } from '../model/User/user.model';
import { Student } from '../model/Student/student.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent {
  student:Student=new Student(0,'','','');
  jwt:JWT = new JWT(new User('','',[],false,false,false,false),'');
  constructor(private httpService : HttpServerService, private router : Router, private data: DataServiceService){
    this.data.currentMessage.subscribe(message => {
      this.jwt = message
    });
    this.data.currentMessageUpdate.subscribe(messageUpdate => {
      this.student = messageUpdate
    });
   }

  postStd(id:any,ten: string, sdt: string, diachi: string){
    if(id != '' && id!= '0'){
      this.httpService.postStudent(new Student(id,ten,sdt,diachi),this.jwt.jwt).subscribe(data =>{
        if(data != null){
          this.router.navigateByUrl('student');
        }else{
          alert("Noop!Add fail")
        }
      })
    }else{
      this.httpService.postStudent(new Student(0,ten,sdt,diachi),this.jwt.jwt).subscribe(data =>{
        if(data != null){
          this.router.navigateByUrl('student');
        }else{
          alert("Noop!Add fail")
        }
      })
    }
    
}
}
