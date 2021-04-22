import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import {LogoutComponent} from './components/logout/logout.component';
import {GameComponent} from './components/game/game.component';
import {RegistrationComponent} from './components/registration/registration.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'game', component: GameComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'registration', component: RegistrationComponent}, // TODO add route Guard;

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
