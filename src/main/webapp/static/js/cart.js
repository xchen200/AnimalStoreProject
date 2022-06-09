
/**
 * add to Shopping Cart
 */
function buy(goodid){
	$.post("buy", {goodid:goodid}, function(data){
		if(data=="ok"){
			layer.msg("Successful operation!", {time:800}, function(){
				location.reload();
			});
		}else if(data=="login"){
			alert("Please login to buy!");
		}else if(data=="empty"){
			alert("Inventory shortage!");
			location.reload();
		}else{
			alert("Request failed!");
		}
	});
}
/**
 * cart minus
 */
function lessen(goodid){
	$.post("lessen", {goodid:goodid}, function(data){
		if(data=="ok"){
			layer.msg("Successful operation!", {time:800}, function(){
				location.href="cart";
			});
		}else if(data=="login"){
			alert("Please login to operate!");
		}else{
			alert("Request failed!");
		}
	});
}
/**
 * delete cart
 */
function deletes(goodid){
	$.post("delete", {goodid:goodid}, function(data){
		if(data=="ok"){
			layer.msg("successfully deleted!", {time:800}, function(){
				location.href="cart";
			});
		}else if(data=="login"){
			alert("Please login to operate!");
		}else{
			alert("Request failed!");
		}
	});
}