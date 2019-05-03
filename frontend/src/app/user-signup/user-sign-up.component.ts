import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {MatDialogRef} from '@angular/material';
import {DataService} from '../services/data.service';

@Component({
  selector: 'app-user-sign-up',
  templateUrl: './user-sign-up.component.html',
  styleUrls: ['./user-sign-up.component.scss']
})
export class UserSignUpComponent implements OnInit {


  frGroup: FormGroup;
  private hide: boolean;

  constructor(private frBuilder: FormBuilder, private dialogRef: MatDialogRef<UserSignUpComponent>,  private dataService: DataService) {
  }

  ngOnInit() {
    this.hide = true;
    this.frGroup = this.frBuilder.group({
      username: ['', [Validators.maxLength(30)]],
      email: ['', [Validators.email]],
      password: ['', [Validators.minLength(6)]],
      confirm: ['']
    });
  }

  getUsernameErrorMessage() {
    return this.fgc.username.hasError('required') ? 'You must enter a value' :
      this.fgc.username.hasError('maxlength') ? `Exceeds the maximum by ${this.fgc.username.value.length - 30}` : '';
  }

  getMailErrorMessage() {
    return this.fgc.email.hasError('required') ? 'You must enter a value' :
      this.fgc.email.hasError('email') ? 'Not a valid email' : '';
  }

  getPasswordErrorMessage() {
    return this.fgc.password.hasError('required') ? 'You must enter a value' :
      this.fgc.password.hasError('minlength') ? `Min 6 characters` : '';
  }

  getPasswordConfirmErrorMessage() {
    return this.fgc.confirm.hasError('required') ? 'You must enter a value' : '';
  }


  get fgc() {
    return this.frGroup.controls;
  }

  sendSignUp() {
    console.log(this.fgc.username.value, this.fgc.password.value);
    this.dataService.postUserPassword(this.fgc.username.value, this.fgc.password.value);
    this.dialogRef.close();
  }

  closeDialog() {
    this.dialogRef.close();
  }

}
