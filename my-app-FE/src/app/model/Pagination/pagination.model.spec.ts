import { Pagination } from './pagination.model';

describe('Pagination', () => {
  it('should create an instance', () => {
    expect(new Pagination([],0)).toBeTruthy();
  });
});
