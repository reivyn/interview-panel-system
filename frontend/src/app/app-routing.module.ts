import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RecoverPasswordComponent} from './recover-password/recover-password.component';
import {UserSignUpComponent} from './user-signup/user-sign-up.component';
import {PanelEntryComponent} from './panel-entry/panel-entry.component';
import {PanelSearchComponent} from './panel-search/panel-search.component';

const routes: Routes = [
  {
    path: 'login', component: LoginComponent,
    children: [
      {
        path: 'register',
        component: UserSignUpComponent
      },
      {
        path: 'forget',
        component: RecoverPasswordComponent
      }
    ]
  },
  {path: 'panelEntry', component: PanelEntryComponent},
  {path: 'panelSearch', component: PanelSearchComponent},
  {path: '**', redirectTo: 'login'}
  // {path: 'forgot', component: LoginComponent},
  // {path: 'register', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
