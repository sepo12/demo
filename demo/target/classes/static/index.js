const accountNumber = document.getElementById("accountNumber");
const accountPin = document.getElementById("accountPin");
const depositAmount = document.getElementById("deposit");


$(document).ready(function() {
    $('#signIn').click(function(){

        var dataString = {
            accountNumber: $('#accountNumber').val(),
            accountPin:$('#accountPin').val()
          
        }
    
    $.ajax({
          type:'POST',
          url:'login',
          data: dataString,
          dataType:'json',
          cache:false,
    
        success: function(response){
    
            if(response.STATUS === 'SUCCESS'){
                
                swal({
    
                    title:'success',
                    text:'Login sucessful. Click ok to continue',
                    type:'success'
    
                })
                setTimeout( function(){
                    windlow.location.href='home'
    
                })
            }
                
           else if(response.STATUS==='ERROR'){
                   swal({
                    title:'error',
                    text:'Login failed. Check credentials to try again',
                    type:'error'
                   })
                }
                
            
        },
        error:function(response){
            $("#serveresponse").html('<p class="alert alert-danger background-danger">internal error occurred. Contact system administrator</p>');
        }
       
    
    
    })
    
    })
}),

$('#atmSign').click(function(){
window.location.href='signUp.html'
}),

$('#signUp').click(function(){

    var dataString ={
        accountNumber: $('#accountNumber').val(),
        accountPin:$('#accountPin').val(),
        firstName:$('#firstName').val(),
        lastName:$('#lastName').val()

    }

$.ajax({
      type:'POST',
      url:'signUp',
      data: dataString,
      dataType:'json',

    success: function(response){

        if(response.status === 'SUCCESS'){
            
            swal({

                title:'success',
                text:'SignUp sucessful. Click ok to continue',
                type:'success'

            })
        }
            
       else if(response.status==='ERROR'){
               swal({
                title:'error',
                text:'SignUp failed.',
                type:'error'
               })
            }
             setTimeout( function(){
                windlow.location.href='/'

            })
        
    },
    error:function(response){
        $("#serveresponse").html('<p class="alert alert-danger bcakground-danger">inter error occurred. Contact system administartor</p>');
    }
   


})

}),

$(document).ready(function(){
 
    var dataString = {
     id: $("id")
    }
    $.ajax({
      type:"GET",
      data:dataString,
      url:"getCurrentUser",
      cache:false,
      dataType: "json",
   
      success: function(response){
         if(response === success){
            swal({
                title: success,
                message: response.message,
                type: success
            })

     
         }
         else if (response === error) {

            swal({
                title : error,
                message: response.error,
                type: error 

            })
         }    
      },

      error : function (){
     $("$serveresponse").html('<p class="alert alert-danger">Internal error occurred. Contact system administrator!</p>');
      }

    })

}),

$(document).ready(function(){
    var dataString = {
      depositAmount :$('depositAmount')
    }

    $.ajax({
        type: 'POST',
        data: dataString,
        url : "deposit",
        cache: false,

        success : function(response){
            if(response.status === success){
                swal({
                    title: "Success",
                    text: response.message,
                    type: "success"
                })
              
            }
            else if (response.status === error) {
              swal ({
                title:"Error",
                text: response.message,
                type : "error"
              })
            }
        },

        error : function() {
            $("serveresponse").html("<p>Internal Error Occured, Contact System Administrator!</p>")
        }
    })
}),

$(document).ready(function(){

    var dataString ={
      withdraw : $("withdraw").val
    }

    $.ajax({
        type:"POST",
        data: dataString,
        url: "",
        cache : false,

        success: function(response){

            if(response === SUCCESS){

        swal({
           type: "SUCCESS",
           text: response.message,
           type: success

                })
            }
            else if (response === ERROR){
                swal({
                    type: "ERROR",
                    text: response.message,
                    type: error
                })
            }

        },

        error : function(response){
        $('serveresponse').html('<P class="alert alert-danger">Internal Error occurred. Contact System Adminstrator!</P>'); 

        }
    })
})




