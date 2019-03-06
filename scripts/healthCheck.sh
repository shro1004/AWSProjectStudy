#!/bin/bash
echo "> Health check 시작"

for RETRY_COUNT in {1..15}
do
  RESPONSE1=$(curl -s http://localhost:8081/actuator/health)
  UP_COUNT1=$(echo $RESPONSE1 | grep 'UP' | wc -l)
  
  RESPONSE2=$(curl -s http://localhost:8082/actuator/health)
  UP_COUNT2=$(echo $RESPONSE2 | grep 'UP' | wc -l)

  if [ $UP_COUNT1 -ge 1 ]
  then # $up_count >= 1 ("UP" 문자열이 있는지 검증)
      echo "> Health check 성공"
      break
  else
      echo "> Health check의 응답을 알 수 없거나 혹은 status가 UP이 아닙니다."
      echo "> Health check: ${RESPONSE1}"
  fi
  
  if [ $UP_COUNT2 -ge 1 ]
  then # $up_count >= 1 ("UP" 문자열이 있는지 검증)
      echo "> Health check 성공"
      break
  else
      echo "> Health check의 응답을 알 수 없거나 혹은 status가 UP이 아닙니다."
      echo "> Health check: ${RESPONSE2}"
  fi

  if [ $RETRY_COUNT -eq 10 ]
  then
    echo "> Health check 실패. "
    exit 1
  fi

  echo "> Health check 연결 실패. 재시도..."
  sleep 10
done
exit 0