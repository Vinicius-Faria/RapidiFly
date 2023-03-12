import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatSnackBarHorizontalPosition, MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

  horizontalPosition: MatSnackBarHorizontalPosition = 'end';

  constructor(
    private router: Router,
    private _snackBar: MatSnackBar,
  ) { }

  ngOnInit(): void {
  }

  logout(){
    this.openSnackBar('Deseja realmente sair ?', 'Sim');
  }

  openSnackBar(message: string, action1: string) {
    let snackBarRef = this._snackBar.open(message, action1, {
      duration: 5000,
      horizontalPosition: this.horizontalPosition,
      panelClass: 'panelClass',
    });

    snackBarRef.onAction().subscribe(() => {
      this.router.navigate(['/login'])
    });
  }
  

}
