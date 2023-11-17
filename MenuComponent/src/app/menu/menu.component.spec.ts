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
    const menu = 
    [
      new MainMenu(1,'Dashboard',[]),
      new MainMenu(2,'Project Manager',[]),
      new MainMenu(3,'Resource Manager',[]),
      new MainMenu(4,'Account Manager',[])
    ];

    testService.getAllMenu(component.idPrj,   component.idRole).subscribe( data=>{
      let getData : Array<MainMenu> = data
      getData.forEach(element => {
        component.listMenu.push(new MainMenu(element.id,element.name,[]) )
      });
      expect(component.listMenu).toEqual(menu);
    })
  }));
  
  it('data MainMenu with user project', async(() => {
    component.idPrj = 1;
    component.idRole = 1;

    const menu = 
    [
      new MainMenu(1,'Dashboard',[
        {
          id:0 ,
          name : '', 
          projectId: 0, 
          mainId: {
            id: 0,
            name: '',
            listChild: []
          }
        }
      ]
  ),
      new MainMenu(2,'Project Manager',[
        {
          id: 4,
          name: "Project Member",
          projectId: 1,
          mainId: {
              id: 2,
              name: '',
              listChild: []
          }
      }
      ]),
      new MainMenu(3,'Resource Manager',[
        {
          id: 0,
          name : '', 
          projectId: 0, 
          mainId: {
            id: 0,
            name: '',
            listChild: []
          }
      }
      ]),
      new MainMenu(4,'Account Manager',[
        {
          id: 0,
          name : '', 
          projectId: 0, 
          mainId: {
            id: 0,
            name: '',
            listChild: []
          }
      }
      ])
    ];

    
  testService.getAllMenu(component.idPrj, component.idRole).subscribe( data=>{
    let getData : Array<MainMenu> = data
    
    getData.forEach(element => {
      let getChild : Array<ChildMenu> = []
      console.log(element.listChild)
      element.listChild.forEach(child => {
        
        if(child.id == null ){
          child.id = 0
        }

        if(child.name == null ){
          child.name = ''
        }

        if(child.projectId == null ){
          child.projectId = 0
        }

        if(child.mainId.id == null ){
          child.mainId.id = 0
        }


        if(child.mainId.name == null ){
          child.mainId.name = ''
        }

        if(child.mainId.listChild == null ){
          child.mainId.listChild = []
        }
        getChild.push(child)
      });
      component.listMenu.push(new MainMenu(element.id,element.name,getChild))
    });
    expect(component.listMenu).toEqual(menu);
  })
  }));

  it('data MainMenu with admin project', async(() => {
    component.idPrj = 1;
    component.idRole = 3;

  const menu = 
    [
      new MainMenu(1,'Dashboard',[
        {
          id:0 ,
          name : '', 
          projectId: 0, 
          mainId: {
            id: 0,
            name: '',
            listChild: []
          }
        }
      ]
  ),
      new MainMenu(2,'Project Manager',[
        {
          id: 1,
          name: "Check project evaluation",
          projectId: 1,
          mainId: {
              id: 2,
              name: '',
              listChild: []
          }
      },
      {
          id: 2,
          name: 'Summary of quality values',
          projectId: 1,
          mainId: {
              id: 2,
              name: '',
              listChild: []
          }
      },
      {
          id: 3,
          name: "Quality index value",
          projectId: 1,
          mainId: {
              id: 2,
              name: '',
              listChild: []
          }
      },
      {
          id: 4,
          name: "Project Member",
          projectId: 1,
          mainId: {
              id: 2,
              name: '',
              listChild: []
          }
      }
      ]),
      new MainMenu(3,'Resource Manager',[
        {
          id: 0,
          name : '', 
          projectId: 0, 
          mainId: {
            id: 0,
            name: '',
            listChild: []
          }
      }
      ]),
      new MainMenu(4,'Account Manager',[
        {
          id: 0,
          name : '', 
          projectId: 0, 
          mainId: {
            id: 0,
            name: '',
            listChild: []
          }
      }
      ])
    ];

    testService.getAllMenu(component.idPrj, component.idRole).subscribe( data=>{
      let getData : Array<MainMenu> = data
      
      getData.forEach(element => {
        let getChild : Array<ChildMenu> = []
        console.log(element.listChild)
        element.listChild.forEach(child => {
          
          if(child.id == null ){
            child.id = 0
          }
  
          if(child.name == null ){
            child.name = ''
          }
  
          if(child.projectId == null ){
            child.projectId = 0
          }
  
          if(child.mainId.id == null ){
            child.mainId.id = 0
          }
  
  
          if(child.mainId.name == null ){
            child.mainId.name = ''
          }
  
          if(child.mainId.listChild == null ){
            child.mainId.listChild = []
          }
          getChild.push(child)
        });
        component.listMenu.push(new MainMenu(element.id,element.name,getChild))
      });
      expect(component.listMenu).toEqual(menu);
    })
  }
  ));


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
