import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Type } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpServerService {
  private REST_API_SERVER = 'http://localhost:8080';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type' : 'application/json',
      }),
  };
  constructor(private httpClient : HttpClient) {}
  public postUser(payload: any): Observable<any>{
      const url = `${this.REST_API_SERVER}/authenticated`;
      return this.httpClient.post<any>(url,payload,this.httpOptions);
  }

  public createUser(payload: any): Observable<any>{
    const url = `${this.REST_API_SERVER}/addUser`;
    return this.httpClient.post<any>(url,payload,this.httpOptions);
}


  public getStudent(jwt:string, page: number, limit: number): Observable<any>{
    this.httpOptions.headers = this.httpOptions.headers.set('Authorization', "Bearer "+jwt)
    const url = `${this.REST_API_SERVER}/students/${page}/${limit}`;
    return this.httpClient.get<any>(url,this.httpOptions)
}

public searchStudent(jwt:string, name:string, page: number, limit: number): Observable<any>{
  this.httpOptions.headers = this.httpOptions.headers.set('Authorization', "Bearer "+jwt)
  const url = `${this.REST_API_SERVER}/search/${name}/${page}/${limit}`;
  return this.httpClient.get<any>(url,this.httpOptions)
}

  public postStudent(payload: any,jwt:string): Observable<any>{
  this.httpOptions.headers = this.httpOptions.headers.set('Authorization', "Bearer "+jwt)
  const url = `${this.REST_API_SERVER}/addStudent`;
  return this.httpClient.post<any>(url,payload,this.httpOptions)
}
  public deleteStudent(id: number,jwt:string): Observable<any>{
  this.httpOptions.headers = this.httpOptions.headers.set('Authorization', "Bearer "+jwt)
  const url = `${this.REST_API_SERVER}/deleteStudent/${id}`;
  return this.httpClient.delete<any>(url,this.httpOptions)
}
}
