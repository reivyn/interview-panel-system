import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import {MatDialogRef} from '@angular/material';

@Component({
  selector: 'app-recover-password',
  templateUrl: './recover-password.component.html',
  styleUrls: ['./recover-password.component.scss']
})
export class RecoverPasswordComponent implements OnInit {


  constructor(private dialogRef: MatDialogRef<RecoverPasswordComponent>) { }

  email = new FormControl('', [Validators.required, Validators.email]);

  getErrorMessage() {
    return this.email.hasError('required') ? 'You must enter a value' :
      this.email.hasError('email') ? 'Not a valid email' :
        '';
  }

  ngOnInit() {}

  sendEmail(data) {
    console.log(`Email enviado -> ${data}`);
    this.dialogRef.close();
  }

  closeDialog() {
    this.dialogRef.close();
  }

}
