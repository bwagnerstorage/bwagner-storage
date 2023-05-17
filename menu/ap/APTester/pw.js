var pw = "view-source:";

function testResults(form) {
    var iv1 = form.inputbox1.value;
  
    document.getElementById("pain").innerHTML = form + " " + iv1;
    
    if(iv1 == pw) {
      window.location.href = "menu/ap/APTester/mainAP.html";
    }
    else {
      alert ("You are wrong");
    }
}
