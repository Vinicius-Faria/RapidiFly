import { Component, OnInit } from '@angular/core';
import { MatSnackBar, MatSnackBarHorizontalPosition } from '@angular/material/snack-bar';
import { LoginService } from '../service/loginService';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loading = false;
  form!: FormGroup;
  horizontalPosition: MatSnackBarHorizontalPosition = 'end';

  constructor(
    private loginService: LoginService,
    private _snackBar: MatSnackBar,
    private formBuilder: FormBuilder,
    private router: Router,
  ) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      nome: ['', [
        Validators.required
      ]],
      senha: ['', [
        Validators.required
      ]]
    });
  }

  onSubmit() {

    this.loading = true;

    if (!this.form.valid) {
      this.openSnackBar('Impossível de realizar o Login, verifique se digitou corretamente.', 'OK');
      this.loading = false;
      return;
    } else {
      this.loginService.verifica(this.form.value).subscribe(
        response => {
          if (response) {
            this.router.navigate(['/app/dashboard']);
          }else{
            this.openSnackBar('Usuário não encontrado.', 'OK');
          }
          this.loading = false;
        }
      );
    }
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 5 * 1000,
      horizontalPosition: this.horizontalPosition,
      panelClass: 'panelClass'
    });
  }
}
