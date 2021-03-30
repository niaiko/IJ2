import { TestBed } from '@angular/core/testing';

import { TokenStrorageService } from './token-strorage.service';

describe('TokenStrorageService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TokenStrorageService = TestBed.get(TokenStrorageService);
    expect(service).toBeTruthy();
  });
});
