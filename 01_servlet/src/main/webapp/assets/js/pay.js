/*
  연습문제.
  최저시급 9,860원으로 계산하기
  8시간 근무는 최저시급 그대로 받고, 초과근무는 1.5배를 받는다.
  workTime 시간 근무했을 때 일급 계산하기
*/
var hourlyWage = 9860;
var workTime = 10;
var result = hourlyWage * 8 + hourlyWage * 1.5 * (workTime - 8);
console.log(result);