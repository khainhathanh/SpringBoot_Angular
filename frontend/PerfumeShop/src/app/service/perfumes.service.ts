import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PerfumesService {
  apiUrl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  getAllPerfumes(){
    return this.http.get<any[]>(this.apiUrl + "/listAllPerfumes");
  }

  getAllCarousels(){
    return this.http.get<any[]>(this.apiUrl + "/listAllCarousel");
  } 
}
