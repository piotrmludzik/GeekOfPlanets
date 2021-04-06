export class Message {
  id: number;
  content: string;
  // tslint:disable-next-line:variable-name
  constructor(private _id: number, public _message: string) {
    this.id = _id;
    this.content = _message;
  }
}
