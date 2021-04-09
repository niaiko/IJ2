import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/_services/auth.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  data = {
    username :"",
    email:"",
    password:"",
    role:["admin"]
  }
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService , private toastr: ToastrService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.authService.register(this.data).subscribe(
      data => {
        if(data.status == 200){
          this.toastr.success("Enregistrement réussi")
          console.log(data);
          this.isSuccessful = true;
          this.isSignUpFailed = false;
        }else{
          this.toastr.warning('Erreur');
        }        
      },
      err => {
        //this.errorMessage = err.error.message;
        this.toastr.error(err.error.message);
        this.isSignUpFailed = true;
      });
  }

  nombre($event) {
    let t0 = $event.target.value.split(".");
    let t1 = $event.target.value.split(",");
    // console.log(t0.length);
    if ($event.key == ",") {
      if (t0.length == 1) $event.target.value = $event.target.value.replace($event.key, '.');
      if (t0.length != 1) $event.target.value = $event.target.value.replace($event.key, '');
    }
    if (t0.length == 1 || t0.length == 2) { }
    else { $event.target.value = $event.target.value.replace($event.key, ''); }
    if (t1.length == 1 || t1.length == 2) { }
    else $event.target.value = $event.target.value.replace($event.key, '');
    if (t0.length == 1 || t1.length == 1) { }
    else $event.target.value = $event.target.value.replace($event.key, '');
    if ($event.key == " ") $event.target.value = $event.target.value.replace($event.key, '');
    if ($event.key != 0 && $event.key != 1 && $event.key != 2
      && $event.key != 3 && $event.key != 4 && $event.key != 5
      && $event.key != 6 && $event.key != 7 && $event.key != 8
      && $event.key != 9 && $event.key != '.' && $event.key != ',' && $event.key != '-') {
      $event.target.value = $event.target.value.replace($event.key, '');
    }
    console.log($event.target.value);
  
  }

}
