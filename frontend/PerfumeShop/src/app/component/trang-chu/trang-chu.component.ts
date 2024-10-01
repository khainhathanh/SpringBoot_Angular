import { Component } from '@angular/core';
import { Route } from '@angular/router';

@Component({
  selector: 'app-trang-chu',
  standalone: true,
  imports: [],
  templateUrl: './trang-chu.component.html',
  styleUrl: './trang-chu.component.css'
})
export class TrangChuComponent {
  constructor (){

  }
  getDetailPerfume(){
    // route.Navigate('/detail-perfume');
  }
}
