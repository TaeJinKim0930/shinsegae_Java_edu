/**
 * module : 코드의 일부를 재사용 할 때 사용 하는 것
 * 			함수와 변수를 포함 할 수 있음 (파일로 작성 된 자바스크립트)
 * 
 * expoer :
 * 			1) named export:
 * 							
 * 			2) default export:
 * 								
 */
let coffee = "Americano";

let getCoffee = function(){
	return coffee.toUpperCase()
};

let setCoffee = function(newValue){
	coffee = newValue
};

export {coffee, getCoffee, setCoffee};
