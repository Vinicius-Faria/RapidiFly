import { Component } from '@angular/core';
import { NgbDatepickerConfig, NgbModalConfig, NgbNavConfig, NgbTimepickerConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-root',
  template: '<router-outlet></router-outlet>'
})
export class AppComponent {
  title = 'RapidiFly';

  constructor(
    modalConfig: NgbModalConfig,
    timepickerConfig: NgbTimepickerConfig,
    datepickerConfig: NgbDatepickerConfig,
    config: NgbNavConfig
  ) {
    modalConfig.backdrop = 'static';
    modalConfig.keyboard = false;

    timepickerConfig.size = 'small';
    timepickerConfig.spinners = false;

    datepickerConfig.firstDayOfWeek = 7;

    config.destroyOnHide = false;
    config.roles = false;
  }
}
