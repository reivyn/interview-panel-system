import {NgModule} from '@angular/core';

import {
  MatSidenavModule,
  MatToolbarModule,
  MatIconModule,
  MatListModule,
  MatInputModule,
  MatSelectModule,
  MatCardModule,
  MatButtonModule,
  MatDialogModule,
  MatMenuModule,
  MatNativeDateModule
} from '@angular/material';

import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';
import {MatCheckboxModule} from '@angular/material/checkbox';



@NgModule({
  imports: [
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    MatDialogModule,
    MatMenuModule,
    MatDatepickerModule,
    MatTableModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatSortModule,
    MatCheckboxModule
  ],
  exports: [
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatInputModule,
    MatSelectModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatDialogModule,
    MatMenuModule,
    MatDatepickerModule,
    MatTableModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatSortModule,
    MatCheckboxModule
  ]
})

export class MaterialModule {
}
