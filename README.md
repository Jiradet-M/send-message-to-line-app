# send-message-to-line-app

steb 1 create line notify token at https://notify-bot.line.me/en/





steb 2 add line token at  

                String url = "https://notify-api.line.me/api/notify";    ///API line///
                String token ="{ line token }";    /// line Token///
                text = editText.getText().toString();    ///get message to text variable ///
                RequestBody requestBody = new MultipartBody.Builder() /// Create requestBody  for send message to line////
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("message", text)
                        .build();
