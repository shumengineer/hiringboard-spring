import {Component} from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
})


export class NavbarComponent {
  public menuItems = [{name: "Home", link: "/"}, {name: "Dashboard", link: "/dashboard"}];
}
