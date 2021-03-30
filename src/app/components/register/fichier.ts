err => {
    this.errorMessage = err.error.message;
    this.toastr.error(err.error.message);
    this.isSignUpFailed = true;
  }  