import { ComponentFixture, TestBed, async } from '@angular/core/testing';

import { MenuComponent } from './menu.component';
import { HttpServerService } from '../Services/http-server.service';
import { MainMenu } from '../Model/main-menu';
import { BrowserModule, By } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ChildMenu } from '../Model/child-menu';

describe('MenuComponent', () => {
  let component: MenuComponent;
  let fixture: ComponentFixture<MenuComponent>;
  let listMainData: Array<MainMenu>;
  let testService: HttpServerService
  let el: HTMLElement;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuComponent ],
      imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule
      ],
      providers: [
        {
          provide: HttpServerService
        }
      ],
    })
    .compileComponents()  ;
    fixture = TestBed.createComponent(MenuComponent);
    component = fixture.componentInstance;
    testService = TestBed.inject(HttpServerService);
  });


  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('data MainMenu initial', async(() => {
    component.listMainMenu = [];
    listMainData = 
    [
      new MainMenu(1,'Dashboard',[]),
      new MainMenu(2,'Project Manager',[]),
      new MainMenu(3,'Resource Manager',[]),
      new MainMenu(4,'Account Manager',[])
    ];
    testService.getAllMainMenu().subscribe( data=>{ 
      let getdata: Array<MainMenu> = data;
      getdata.forEach(element => {
        element.child =[]
        component.listMainMenu.push(new MainMenu(element.id,element.name,element.child))
      });
      expect(component.listMainMenu).toEqual(listMainData);
    })
  }));

  it('data MainMenu with user project', async(() => {
    component.idPrj = 1;
    component.idRole = 1;
    listMainData  = 
    [
      new MainMenu(1,'Dashboard',[]),
      new MainMenu(2,'Project Manager',[
        {id:8, name:'Project Member',projectId: 1,mainId: 2 }
      ]),
      new MainMenu(3,'Resource Manager',[]),
      new MainMenu(4,'Account Manager',[])
  ];
  component.listChild = [];
  testService.getAllMainMenu().subscribe( data=>{ 
    let getdata: Array<MainMenu> = data;
    if(component.idPrj > 0){
      testService.getAllChildMenu(component.idPrj, component.idRole).subscribe(childData =>{
        component.listChildMenu = childData;
        getdata.forEach(element => {
          component.listChildMenu.forEach(child => {
            if(child.mainId == element.id){
              component.listChild.push(child)
              element.child = component.listChild
            }else{
              element.child =[]
            }
          });
          component.listMainMenu.push(new MainMenu(element.id,element.name,element.child))
        });
        expect(component.listMainMenu).toEqual(listMainData);
      })
    }
  })
  }));

  it('data MainMenu with admin project', async(() => {
    component.idPrj = 1;
    component.idRole = 3;
    listMainData  = 
    [
      new MainMenu(1,'Dashboard',[]),
      new MainMenu(2,'Project Manager',[
        {id:5, name:'Check project evaluation',projectId: 1,mainId: 2 },
        {id:6, name:'Summary of quality values',projectId: 1,mainId: 2 },
        {id:7, name:'Quality index value',projectId: 1,mainId: 2 },
        {id:8, name:'Project Member',projectId: 1,mainId: 2 }
      ]),
      new MainMenu(3,'Resource Manager',[]),
      new MainMenu(4,'Account Manager',[])
  ];

  component.listChild = [];
  testService.getAllMainMenu().subscribe( data=>{ 
    let getdata: Array<MainMenu> = data;
    if(component.idPrj > 0){
      testService.getAllChildMenu(component.idPrj, component.idRole).subscribe(childData =>{
        component.listChildMenu = childData;
        getdata.forEach(element => {
          component.listChildMenu.forEach(child => {
            if(child.mainId == element.id){
              component.listChild.push(child)
              element.child = component.listChild
            }else{
              element.child =[]
            }
          });
          component.listMainMenu.push(new MainMenu(element.id,element.name,element.child))
        });
        expect(component.listMainMenu).toEqual(listMainData);
      })
    }
  })
  }));


  it('data Dashboard', (() => {
    component.handleClick('Dashboard');
    expect(component.url).toEqual('http://localhost:8080/Dashboard');
  }));

  it('data Resource Manager', async(() => {
    component.handleClick('Resource Manager');
    expect(component.url).toEqual('http://localhost:8080/Resource Manager');
  }));

  it('data Account Manager', async(() => {
    component.handleClick('Account Manager');
    expect(component.url).toEqual('http://localhost:8080/Account Manager');
  }));

  it('data Check project evaluation', async(() => {
    component.handleClick('Check project evaluation');
    expect(component.url).toEqual('http://localhost:8080/Check project evaluation');
  }));

  it('data Summary of quality values', async(() => {
    component.handleClick('Summary of quality values');
    expect(component.url).toEqual('http://localhost:8080/Summary of quality values');
  }));

  it('data Quality index value', async(() => {
    component.handleClick('Quality index value');
    expect(component.url).toEqual('http://localhost:8080/Quality index value');
  }));

  it('data Project Member', async(() => {
    component.handleClick('Project Member');
    expect(component.url).toEqual('http://localhost:8080/Project Member');
  }));
});
