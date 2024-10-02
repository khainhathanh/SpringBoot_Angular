import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { MenuComponent } from './component/menu/menu.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { PerfumesService } from './service/perfumes.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,HeaderComponent, FooterComponent,MenuComponent,FontAwesomeModule,HttpClientModule],
  providers: [PerfumesService] ,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'PerfumeShop';
}
