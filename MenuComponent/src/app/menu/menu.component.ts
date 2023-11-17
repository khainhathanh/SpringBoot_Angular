import { Component,Input} from '@angular/core';
import { HttpServerService } from '../Services/http-server.service';
import { MainMenu } from '../Model/main-menu';
import { ChildMenu } from '../Model/child-menu';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})

export class MenuComponent {
  @Input() idPrj :number = 0;
  @Input() idRole : number = 0;
  @Input() url : string = '';
  @Input() listMainMenu : Array<MainMenu> = [];
  listChildMenu : Array<ChildMenu> =[];
  listChild: Array<ChildMenu> = [];
constructor(private httpService : HttpServerService){
}

  public ngOnInit(): void{
    this.listChild = [];
    this.httpService.getAllMainMenu().subscribe( data=>{ 
      this.listMainMenu = data;
      if(this.idPrj > 0){
        this.httpService.getAllChildMenu(this.idPrj, this.idRole).subscribe(childData =>{
          this.listChildMenu = childData;
          this.listMainMenu.forEach(main =>{
            this.listChildMenu.forEach(element => {
              if(element.mainId == main.id){
                this.listChild.push(element)
                main.child = this.listChild
              }
            });
          })
        })
      }
    })
  }

  handleClick(name: string) {
    this.url = this.httpService.getInfo(name);
    console.log(this.url)
  }
}
