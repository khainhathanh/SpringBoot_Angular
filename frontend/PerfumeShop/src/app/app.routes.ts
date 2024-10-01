import { Routes } from '@angular/router';
import { TrangChuComponent } from './component/trang-chu/trang-chu.component';
import { DetailPerfumeComponent } from './component/detail-perfume/detail-perfume.component';
import { CartPerfumeComponent } from './component/cart-perfume/cart-perfume.component';
import { PaymentPerfumeComponent } from './component/payment-perfume/payment-perfume.component';

export const routes: Routes = [
    { path: '', component: TrangChuComponent },
    { path: 'trang-chu', component: TrangChuComponent },
    { path: 'detail-perfume', component: DetailPerfumeComponent },
    { path: 'cart-perfume', component: CartPerfumeComponent },
    { path: 'payment-perfume', component: PaymentPerfumeComponent }
];
