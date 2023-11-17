import {  Meta, StoryObj, applicationConfig } from '@storybook/angular';
import { MenuComponent } from './menu.component';
import { importProvidersFrom } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

    const meta: Meta<MenuComponent> = {
        component: MenuComponent,
        decorators: [
            applicationConfig({
              providers: [
                importProvidersFrom(HttpClientModule),
              ],
            }),
            
          ],

      };

    export default meta;
    type Story = StoryObj< MenuComponent>;
    export const Menu: Story = {
    };

    export const MenuHasProject: Story = {
      args: {
          idPrj : 1,
          idRole: 1,
        }
    };