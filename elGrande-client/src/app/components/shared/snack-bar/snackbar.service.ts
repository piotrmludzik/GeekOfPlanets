import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SnackbarService {



  private snackbarSubject = new Subject<any>();
  public snackbarState = this.snackbarSubject.asObservable();

  constructor() { }

  public show(message: string, type?: string): void {
    this.snackbarSubject.next({
      show: true,
      message,
      type
    });
  }




}
