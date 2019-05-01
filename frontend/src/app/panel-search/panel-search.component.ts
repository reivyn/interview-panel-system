import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {DataService} from '../services/data.service';
import {Post} from '../models/post.model';
import {Subscription} from 'rxjs';


export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

const USER_DATA: any[] = [
  {
    id: 1,
    user_id: 3,
    id_syne: 1,
    name: 'Panel 1',
    surname: 'Dummy 1',
    phone: 1234567890,
    extension: 123,
    email_syne: 'panel1.dummy@synechron.com',
    email_wf: 'panel1.dummy@wellsfargo.com',
    designation: 'Developer',
    level: {L1: 1, L2: 0, L3: 0},
    skills: ['Java', 'Angular', 'Cloud'],
    slots: [{
      block: 0,
      skills: ['Java', 'Java Spring', 'Angular'],
      endDate: '02/01/2019',
      endTime: '01:00 PM',
      startDate: '01/01/2019',
      startTime: '12:00 PM'
    },
      {
        block: 1,
        skills: ['Java', 'Java Spring', 'Angular'],
        endDate: '02/01/2019',
        endTime: '01:00 PM',
        startDate: '01/01/2019',
        startTime: '12:00 PM'
      },
      {
        block: 1,
        skills: ['Java', 'Java Spring', 'Angular'],
        endDate: '02/01/2019',
        endTime: '01:00 PM',
        startDate: '01/01/2019',
        startTime: '12:00 PM'
      }]
  },
  {
    id: 2,
    user_id: 3,
    id_syne: 2,
    name: 'Panel 2',
    surname: 'Dummy 2',
    phone: 9876543210,
    extension: 321,
    email_syne: 'panel2.dummy@synechron.com',
    email_wf: 'panel2.dummy@wellsfargo.com',
    designation: 'DBA',
    level: {L1: 0, L2: 1, L3: 1},
    skills: ['Angular', 'React'],
    slots: [
      {
        block: 1,
        skills: ['Angular', 'React'],
        endDate: '03/05/2019',
        endTime: '07:00 PM',
        startDate: '02/06/2019',
        startTime: '9:00 PM'
      },
      {
        block: 0,
        skills: ['Angular', 'React'],
        endDate: '03/05/2019',
        endTime: '07:00 PM',
        startDate: '02/06/2019',
        startTime: '9:00 PM'
      }]
  },
  {
    id: 3,
    user_id: 3,
    id_syne: 3,
    name: 'Panel 3',
    surname: 'Dummy 3',
    phone: 12345987650,
    extension: 456,
    email_syne: 'panel3.dummy@synechron.com',
    email_wf: 'panel3.dummy@wellsfargo.com',
    designation: 'Manager',
    level: {L1: 1, L2: 0, L3: 1},
    skills: ['Cloud'],
    slots: [{
      block: 0,
      skills: ['Cloud'],
      endDate: '03/13/2019',
      endTime: '03:00 AM',
      startDate: '04/24/2019',
      startTime: '04:00 AM'
    }]
  },
  {
    id: 4,
    user_id: 4,
    id_syne: 4,
    name: 'Panel 4',
    surname: 'Dummy 4',
    phone: 12345987650,
    extension: 456,
    email_syne: 'panel4.dummy@synechron.com',
    email_wf: 'panel4.dummy@wellsfargo.com',
    designation: 'Manager',
    level: {L1: 0, L2: 2, L3: 1},
    skills: ['Angular'],
    slots: [{
      block: 0,
      skills: ['Cloud'],
      endDate: '03/13/2019',
      endTime: '03:00 AM',
      startDate: '04/24/2019',
      startTime: '04:00 AM'
    }]
  },
  {
    id: 5,
    user_id: 5,
    id_syne: 5,
    name: 'Panel 5',
    surname: 'Dummy 5',
    phone: 12345987650,
    extension: 456,
    email_syne: 'panel5.dummy@synechron.com',
    email_wf: 'panel5.dummy@wellsfargo.com',
    designation: 'Manager',
    level: {L1: 0, L2: 0, L3: 0},
    skills: ['Cloud'],
    slots: [{
      block: 0,
      skills: ['Cloud'],
      endDate: '03/13/2019',
      endTime: '03:00 AM',
      startDate: '04/24/2019',
      startTime: '04:00 AM'
    }]
  },
  {
    id: 6,
    user_id: 6,
    id_syne: 6,
    name: 'Panel 6',
    surname: 'Dummy 6',
    phone: 12345987650,
    extension: 456,
    email_syne: 'panel6.dummy@synechron.com',
    email_wf: 'panel6.dummy@wellsfargo.com',
    designation: 'Developer',
    level: {L1: 0, L2: 1, L3: 0},
    skills: ['Spring'],
    slots: [{
      block: 0,
      skills: ['Cloud'],
      endDate: '03/13/2019',
      endTime: '03:00 AM',
      startDate: '04/24/2019',
      startTime: '04:00 AM'
    }]
  }
];

@Component({
  selector: 'app-panel-search',
  templateUrl: './panel-search.component.html',
  styleUrls: ['./panel-search.component.scss']
})
export class PanelSearchComponent implements OnInit {
  // levelKeys = Object.keys;
  // levelValues = Object.values;
  lockBlock: any[];
  blockblock: any;
  apiData: any;

  displayedColumns: string[] = [
    'id_syne', 'name', 'surname', 'skills', 'level', 'slots', 'phone', 'email_syne', 'slot_lock'
  ];

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;


  // posts: Array<Post>;
  message: string;
  gpSubscription: Subscription;
  private dataSource: MatTableDataSource<any>;

  constructor(private dataService: DataService) {
  }

  ngOnInit() {

    this.lockBlock = [];
    this.blockblock = '';


    this.gpSubscription = this.dataService.getAllPanels().subscribe((resData: Post[]) => {
      console.log(resData);
      console.log(USER_DATA);
      this.apiData = resData;
      this.message = '';
      // this.dataSource = new MatTableDataSource(USER_DATA);
      this.dataSource = new MatTableDataSource(resData);
      this.dataSource.paginator = this.paginator;
      for (let i = 0; i < this.dataSource.data.length; i++) {
        this.lockBlock.push(0);
      }
    }, (err: string) => {
      this.message = err;
    });
    // = this.dService.getAllPosts();


  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  updateBlock(element) {
    console.log(this.lockBlock);
    console.log(this.apiData);
    console.log(this.gpSubscription);
  }
}
