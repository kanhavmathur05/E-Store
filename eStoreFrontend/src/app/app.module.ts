import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

import { RouterModule, Routes } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'

import { MaterialModule } from './material.module';

import { ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { ShowProductComponent } from './show-product/show-product.component';
import { HeaderComponent } from './header/header.component';
import { CartComponent } from './cart/cart.component';
import { UsermanagementComponent } from './usermanagement/usermanagement.component';
import { UserinfoComponent } from './userinfo/userinfo.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';

const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path:'product/:id', component:ShowProductComponent},
  { path:'cart/:id', component:CartComponent},
  { path:'userinfo/:id', component:UserinfoComponent },
  { path:'usermanagement', component:UsermanagementComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ShowProductComponent,
    HeaderComponent,
    CartComponent,
    UsermanagementComponent,
    UserinfoComponent,
    AdminDashboardComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
