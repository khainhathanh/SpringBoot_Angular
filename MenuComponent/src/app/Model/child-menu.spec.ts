import { ChildMenu } from './child-menu';
import { MainMenu } from './main-menu';

describe('ChildMenu', () => {
  it('should create an instance', () => {
    expect(new ChildMenu(0, '',new MainMenu(0,'',[]), 0)).toBeTruthy();
  });
});
