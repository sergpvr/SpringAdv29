https://github.com/sergpvr/SpringAdv29  - source code

1. login as admin/admin
2. got to /dataBatchUpload for data batch downloading (data_for_upload.xml) users and events
   or add them by UI (/users  /events)
3. /logout
4. login under credentials of any users

  after login
  you will be redirected to /tickets
  if users=0 - to /users
  else if events=0 - to /events

5. do any operations allowed by current credentials
6. add .pdf to /tickets(/users or /events) for getting pdf documents  (or ask them with Accept='application/pdf')

