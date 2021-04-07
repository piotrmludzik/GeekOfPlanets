import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import {CanvasComponent} from './components/canvas/canvas.component';
import {LogoutComponent} from './components/logout/logout.component';
import {MenuComponent} from './components/menu/menu.component';
import {GameComponent} from './components/game/game.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent},
  {path: 'game', component: GameComponent},
  {path: 'logout', component: LogoutComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
