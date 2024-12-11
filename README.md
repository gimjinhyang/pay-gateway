# pay-gateway

pay gateway

* * *

#### API

* Register payment card information
    * Path
        * [post] /card
    * Params
        ```
        {
          "payerCi": "CI numbers",
          "payerName": "card payer name",
          "code": "card company code",
          "number": "card numbers",
          "validYear": "card expire year",
          "validMonth": "card expire month",
          "cvs": "card cvs"
        }
        ```
    * Response
        ```
        {
          "status": 200,
          "message": "success",
          "data": {
            "cardRefId": 1
          }
        }
        ```

* Request payment
    * Path
        * [post] /pay
    * Params
      ```
      {
        "cardRefId": 1
      }
      ```
    * Response
        ```
        {
          "status": 200,
          "message": "success",
        }
        ```

* * *

##### Swagger

```
http://localhost:1001/swagger-ui/index.html
```
