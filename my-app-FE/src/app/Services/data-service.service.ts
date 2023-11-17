import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { JWT } from '../model/JWT/jwt.model';
import { Student } from '../model/Student/student.model';
@Injectable()
export class DataServiceService {
  private messageSource = new BehaviorSubject<any>('');
  currentMessage = this.messageSource.asObservable();
  private messageUpdate = new BehaviorSubject<any>('Default message');
  currentMessageUpdate = this.messageUpdate.asObservable();
  constructor() { 
    
  }
  changeMessage(message: JWT) {
    this.messageSource.next(message);
  }
  changMessageUpdate(message: Student) {
    this.messageUpdate.next(message);
  }
}
