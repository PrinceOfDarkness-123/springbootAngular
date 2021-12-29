import { Component, Input, OnInit } from '@angular/core';
import { ApplicantService } from '../applicant.service';
import { Applicant } from '../applicant';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';



@Component({
  selector: 'app-form-component',
  templateUrl: './form-component.component.html',
  styleUrls: ['./form-component.component.css']
})
export class FormComponentComponent implements OnInit {
  applicant: Applicant = new Applicant();
  submitted = false;
  myForm!: FormGroup;
  @Input()
  pattern!: string | RegExp;
  
  constructor(private applicantService: ApplicantService, private router: Router,
    private fb: FormBuilder)
     { 
      this.createForm();
     }
     createForm(){
      
       this.myForm = this.fb.group({
         fullname: ['', Validators.required],
         email: ['', Validators.required],
         phone: ['', Validators.required],
         street: ['', Validators.required],
         deg: ['', Validators.required],
         sch: ['', Validators.required],
         achieve: ['', Validators.required],
         start: ['', Validators.required],
         end: ['', Validators.required]

       })
     }
     

  ngOnInit(): void {
  }
  
  save(){
    this.applicantService.createApplicant(this.applicant).subscribe(data => {
      console.log(data)
      this.applicant = new Applicant();
    },
    error => console.log(error));
    
  }
  onSubmit(){
    this.submitted = true;
    this.save();
  }
  
  
 title="Personal Details";
 title2="Academic";
 title3="Experience";
 value1="";
 value2="";
 value3="";
 value4="";
 value5="";
 value6="";
 classExpression="specialdate";
 p1="Please Select";
 selectedDegree: string = '';
 start_date: string = '';
 end_date: string = '';

 selectChangeHandler(event: any){
     this.selectedDegree = event.target.value;
 }
 selectStart(event: any){
   this.start_date = event.target.value;
 }
 selectEnd(event: any){
  this.end_date = event.target.value;
}
 handleInput1(event: any) {
  this.value1 = (event.target as HTMLInputElement).value;
}
handleInput2(event: any){
  this.value2 = (event.target as HTMLInputElement).value;
}
handleInput3(event: any){
  this.value3 = (event.target as HTMLInputElement).value;
}
handleInput4(event: any){
  this.value4 = (event.target as HTMLInputElement).value;
}
handleInput5(event: any){
  this.value5 = (event.target as HTMLInputElement).value;
}
handleInput6(event: any){
  this.value6 = (event.target as HTMLInputElement).value;
}
items: item[] = [{name:'Bachelor of Science in Computer Science',val:1},{name: 'Bachelor of science in Electrical Engineering', val: 2}, {name: 'Bachelor of Business Administration', val: 3}, {name: 'Bachelor of Science in Mass Communication', val: 4}, {name: 'Bachelor of Science in Software Engineering', val: 5}];
    selectedValue1: string= 'Bachelor of Science in Computer Science';
    selectedValue2: string= 'Bachelor of science in Electrical Engineering';
    selectedValue3: string= 'Bachelor of Business Administration';
    selectedValue4: string= 'Bachelor of Science in Computer Science';
}
//using array of objects
class item{
  name: string = '';
  val: number = 0;

}


