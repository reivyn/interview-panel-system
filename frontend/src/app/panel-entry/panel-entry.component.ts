import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {MatTableDataSource} from '@angular/material';

const sampleSkillsData: string[] = ['Spring boot', 'Java', 'Angular', 'React', 'Mule', 'Cloud'];
const sampleSlotData: any[] = [
  {
    block: 0,
    skills: ['Java', 'Java Spring', 'Angular'],
    endDate: '02/01/2019',
    endTime: '1 PM',
    startDate: '01/01/2019',
    startTime: '12 PM'
  },
  {
    block: 0,
    skills: ['Java', 'Java Spring', 'Angular'],
    endDate: '02/01/2019',
    endTime: '1 PM',
    startDate: '01/01/2019',
    startTime: '12 PM'
  },
  {
    block: 0,
    skills: ['Java', 'Java Spring', 'Angular'],
    endDate: '02/01/2019',
    endTime: '1 PM',
    startDate: '01/01/2019',
    startTime: '12 PM'
  }
];


// const ELEMENT_DATA: PeriodicElement[] = [
//   {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
//   {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
//   {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
//   {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
//   {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
//   {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
//   {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
//   {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
//   {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
//   {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
// ];

@Component({
  selector: 'app-panel-entry',
  templateUrl: './panel-entry.component.html',
  styleUrls: ['./panel-entry.component.scss']
})
export class PanelEntryComponent implements OnInit {
  regForm: FormGroup;
  startSlotData: [{ startDate: string, endDate: string, startTime: string, endTime: string }?];
  dataSource = new MatTableDataSource(this.startSlotData);
  // Skill Multi Select
  skills = new FormControl();
  skillsList = sampleSkillsData;

  // Slot Table
  displayedColumns: string[] = ['startDate', 'endDate', 'startTime', 'endTime', 'removeSlot'];
  // dataSource = this.startSlotData;
  // dataSource = sampleSlotData;
  slot: boolean;

  constructor(private frBuilder: FormBuilder) {
  }

  ngOnInit() {
    console.log(this.dataSource);
    console.log(this.dataSource.data.length);
    this.startSlotData = [];
    this.regForm = this.frBuilder.group({
      synechronId: ['', [Validators.required]],
      name: ['', [Validators.required]],
      surname: ['', [Validators.required]],
      emailSyne: ['', [Validators.required]],
      emailWF: ['', [Validators.required]],
      mobile: ['', [Validators.required]],
      extension: [''],
      skills: [[], [Validators.required]],
      designation: ['', [Validators.required]],
      startDate: [''],
      endDate: [''],
      startTime: [''],
      endTime: [''],
      slots: [[], [Validators.required]]
    });
  }

  get fgc() {
    return this.regForm.controls;
  }

  addSlot() {
    this.startSlotData.push({
      startDate: this.fgc.startDate.value,
      endDate: this.fgc.endDate.value,
      startTime: this.fgc.startTime.value,
      endTime: this.fgc.endTime.value
    });
    this.dataSource = new MatTableDataSource(this.startSlotData);

    this.fgc.slots.setValue(this.startSlotData);
    this.fgc.startDate.reset('');
    this.fgc.endDate.reset('');
    this.fgc.startTime.reset('');
    this.fgc.endTime.reset('');
  }

  removeSlot(index) {
    console.log(index);
    this.startSlotData.splice(index, 1);
    // this.dataSource.push({ startDate: '1', endDate: '2', startTime: '3', endTime: '4' });
    this.dataSource = new MatTableDataSource(this.startSlotData);
    console.log(this.startSlotData);
    console.log(this.dataSource);
    // this.dataSource = this.startSlotData;

  }

  addPanelEntry() {
    console.log('Datos Ingresados');
    console.log(this.regForm.value);
    this.regForm.disable();

  }

  showSelect() {
    console.log(this.fgc.skills.value);
    console.log(this.regForm.value);
  }

  editPanelForm() {
    this.fgc.mobile.enable();
    this.fgc.extension.enable();
    this.fgc.skills.enable();
    this.fgc.designation.enable();
    this.fgc.startDate.enable();
    this.fgc.endDate.enable();
    this.fgc.startTime.enable();
    this.fgc.endTime.enable();
    this.fgc.slots.enable();
  }

  savePanelForm() {
    this.regForm.disable();
  }
}
