import { Student } from './student.model';

describe('Student', () => {
  it('should create an instance', () => {
    expect(new Student(0,'','','')).toBeTruthy();
  });
});
