import { Component,Input} from '@angular/core';
import { HttpServerService } from '../Services/http-server.service';
import { MainMenu } from '../Model/main-menu';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})

export class MenuComponent {
  @Input() idPrj :number = 0;
  @Input() idRole : number = 1;
  @Input() url : string = '';
  @Input() listMenu : Array<MainMenu> = [];
  constructor(private httpService : HttpServerService){
  }

  public ngOnInit(): void{
    this.httpService.getAllMenu(this.idPrj, this.idRole).subscribe(data =>{
      this.listMenu = data;
      console.log(this.listMenu)
    })
  }

  handleClick(name: string) {
    this.url = this.httpService.getInfo(name);
    console.log(this.url)
  }
}
