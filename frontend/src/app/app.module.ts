// Core Modules
import {NgModule} from '@angular/core';

// Angular Modules
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

// Third-party Modules
import {MaterialModule} from './material.module';

// Components
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import { RecoverPasswordComponent } from './recover-password/recover-password.component';
import { UserSignUpComponent } from './user-signup/user-sign-up.component';
import { PanelEntryComponent } from './panel-entry/panel-entry.component';
import {NgxMaterialTimepickerModule} from 'ngx-material-timepicker';
import { PanelSearchComponent } from './panel-search/panel-search.component';
import { AppRoutingModule } from './app-routing.module';
import {DataService} from './services/data.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RecoverPasswordComponent,
    UserSignUpComponent,
    PanelEntryComponent,
    PanelSearchComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    MaterialModule,
    ReactiveFormsModule,
    NgxMaterialTimepickerModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [DataService],
  bootstrap: [AppComponent],
  entryComponents: [RecoverPasswordComponent, UserSignUpComponent]
})
export class AppModule {
}
