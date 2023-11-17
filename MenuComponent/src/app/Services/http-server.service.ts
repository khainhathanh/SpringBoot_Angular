import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

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
  public getAllMainMenu(): Observable<any>{
    const url = `${this.REST_API_SERVER}/mainMenu`;
    return this.httpClient.get<any>(url,this.httpOptions)
  }

  public getAllChildMenu(idPrj:number, idRole:number): Observable<any>{
    const url = `${this.REST_API_SERVER}/childMenu/${idPrj}/${idRole}`;
    return this.httpClient.get<any>(url,this.httpOptions)
  }

  public getInfo(name: any):  string{
    this.url = `${this.REST_API_SERVER}/${name}`; 
    return this.url;
  }
}
    const listDataDashboard = 'http://localhost:8080/dashboard';
    const listDataResource = 'http://localhost:8080/resource';
    const listDataAccount = 'http://localhost:8080/account';
    const listDataCheckProject = 'http://localhost:8080/checklist';
    const listDataSummary = 'http://localhost:8080/summary';
    const listDataQuality ='http://localhost:8080/quality';
    const listDataMember = 'http://localhost:8080/member';