import * as myMember from "./member1.js";

console.log(myMember.member.getName());
myMember.member.setName("흥길동");

console.log(myMember.member.getName());

let name = myMember.member.getName();
let age = myMember.member.getAge();
let dep = myMember.member.getDep();

console.log(`${name}은 ${age}살이고 ${dep}에 다닙니다.`)