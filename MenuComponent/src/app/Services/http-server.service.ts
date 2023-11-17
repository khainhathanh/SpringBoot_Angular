import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MainMenu } from '../Model/main-menu';

@Injectable({
  providedIn: 'root'
})

export class HttpServerService {
  private url :any
  private REST_API_SERVER = 'http://localhost:8080';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type' : 'application/json',
      }),
  };
  constructor(private httpClient : HttpClient) { }

  public getAllMenu(idPrj:number, idRole:number): Observable<Array<MainMenu>>{
    const url = `${this.REST_API_SERVER}/menu?role=${idRole}&project=${idPrj}`;
    return this.httpClient.get<any>(url,this.httpOptions)
  }

  public getInfo(name: any):  string{
    this.url = `${this.REST_API_SERVER}/${name}`; 
    return this.url;
  }
}