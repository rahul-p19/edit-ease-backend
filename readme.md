---
title: EditEase Backend Docs v1
language_tabs:
  - shell: cURL
language_clients:
  - shell: ""
toc_footers: []
includes: []
search: true
highlight_theme: darkula
headingLevel: 2

---

<!-- Generator: Widdershins v4.0.1 -->

<h1 id="editease-backend-docs">EditEase Backend Docs v1</h1>

> Scroll down for code samples, example requests and responses.

By rahul-p19

Base URLs:

* <a href="http://localhost:8080">http://localhost:8080</a>

# Authentication

- HTTP Authentication, scheme: bearer 

<h1 id="editease-backend-docs-event-apis">Event APIs</h1>

View and Edit Event Data

## getEventData

<a id="opIdgetEventData"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/events/{path} \
  -H 'Accept: */*' \
  -H 'Authorization: Bearer {access-token}'

```

`GET /api/events/{path}`

<h3 id="geteventdata-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|path|path|string|true|none|

> Example responses

> 200 Response

<h3 id="geteventdata-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[Event](#schemaevent)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## updateEventData

<a id="opIdupdateEventData"></a>

> Code samples

```shell
# You can also use wget
curl -X PUT http://localhost:8080/api/events/{path} \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*' \
  -H 'Authorization: Bearer {access-token}'

```

`PUT /api/events/{path}`

> Body parameter

```json
{
  "slug": "string",
  "name": "string",
  "description": "string",
  "rules": [
    "string"
  ],
  "category": "CODING",
  "prizes": [
    "string"
  ],
  "registrationDeadline": "2019-08-24T14:15:22Z",
  "teamSize": "string",
  "eventDates": [
    "string"
  ],
  "organisers": [
    {
      "name": "string",
      "phoneNumber": "string"
    }
  ]
}
```

<h3 id="updateeventdata-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|path|path|string|true|none|
|body|body|[Event](#schemaevent)|true|none|

> Example responses

> 200 Response

<h3 id="updateeventdata-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[Event](#schemaevent)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

<h1 id="editease-backend-docs-user-authentication-apis">User Authentication APIs</h1>

Login and Register.

## register

<a id="opIdregister"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/api/auth/register \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*' \
  -H 'Authorization: Bearer {access-token}'

```

`POST /api/auth/register`

> Body parameter

```json
{
  "username": "string",
  "password": "string",
  "email": "string",
  "roles": [
    "string"
  ],
  "eventSlug": "string"
}
```

<h3 id="register-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[Users](#schemausers)|true|none|

> Example responses

> 200 Response

<h3 id="register-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[AuthResponse](#schemaauthresponse)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## login

<a id="opIdlogin"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/api/auth/login \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*' \
  -H 'Authorization: Bearer {access-token}'

```

`POST /api/auth/login`

> Body parameter

```json
{
  "username": "string",
  "password": "string",
  "email": "string",
  "roles": [
    "string"
  ],
  "eventSlug": "string"
}
```

<h3 id="login-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[Users](#schemausers)|true|none|

> Example responses

> 200 Response

<h3 id="login-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[AuthResponse](#schemaauthresponse)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

<h1 id="editease-backend-docs-health-api">Health API</h1>

## health

<a id="opIdhealth"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/health \
  -H 'Accept: */*' \
  -H 'Authorization: Bearer {access-token}'

```

`GET /api/health`

> Example responses

> 200 Response

<h3 id="health-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|string|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

<h1 id="editease-backend-docs-admin-apis">Admin APIs</h1>

## getAllEvents

<a id="opIdgetAllEvents"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/admin/getAllEvents \
  -H 'Accept: */*' \
  -H 'Authorization: Bearer {access-token}'

```

`GET /api/admin/getAllEvents`

> Example responses

> 200 Response

<h3 id="getallevents-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getallevents-responseschema">Response Schema</h3>

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

# Schemas

<h2 id="tocS_Event">Event</h2>
<!-- backwards compatibility -->
<a id="schemaevent"></a>
<a id="schema_Event"></a>
<a id="tocSevent"></a>
<a id="tocsevent"></a>

```json
{
  "slug": "string",
  "name": "string",
  "description": "string",
  "rules": [
    "string"
  ],
  "category": "CODING",
  "prizes": [
    "string"
  ],
  "registrationDeadline": "2019-08-24T14:15:22Z",
  "teamSize": "string",
  "eventDates": [
    "string"
  ],
  "organisers": [
    {
      "name": "string",
      "phoneNumber": "string"
    }
  ]
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|slug|string|false|none|none|
|name|string|false|none|none|
|description|string|false|none|none|
|rules|[string]|false|none|none|
|category|string|false|none|none|
|prizes|[string]|false|none|none|
|registrationDeadline|string(date-time)|false|none|none|
|teamSize|string|false|none|none|
|eventDates|[string]|false|none|none|
|organisers|[[Organiser](#schemaorganiser)]|false|none|none|

#### Enumerated Values

|Property|Value|
|---|---|
|category|CODING|
|category|CIRCUITS_AND_ROBOTICS|
|category|BUSINESS|
|category|BRAINSTORMING|
|category|GAMING|
|category|MISCELLANEOUS|

<h2 id="tocS_Organiser">Organiser</h2>
<!-- backwards compatibility -->
<a id="schemaorganiser"></a>
<a id="schema_Organiser"></a>
<a id="tocSorganiser"></a>
<a id="tocsorganiser"></a>

```json
{
  "name": "string",
  "phoneNumber": "string"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|name|string|false|none|none|
|phoneNumber|string|false|none|none|

<h2 id="tocS_Users">Users</h2>
<!-- backwards compatibility -->
<a id="schemausers"></a>
<a id="schema_Users"></a>
<a id="tocSusers"></a>
<a id="tocsusers"></a>

```json
{
  "username": "string",
  "password": "string",
  "email": "string",
  "roles": [
    "string"
  ],
  "eventSlug": "string"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|username|string|false|none|none|
|password|string|false|none|none|
|email|string|false|none|none|
|roles|[string]|false|none|none|
|eventSlug|string|false|none|none|

<h2 id="tocS_AuthResponse">AuthResponse</h2>
<!-- backwards compatibility -->
<a id="schemaauthresponse"></a>
<a id="schema_AuthResponse"></a>
<a id="tocSauthresponse"></a>
<a id="tocsauthresponse"></a>

```json
{
  "token": "string",
  "role": "string",
  "slug": "string",
  "ok": true,
  "message": "string"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|token|string|false|none|none|
|role|string|false|none|none|
|slug|string|false|none|none|
|ok|boolean|false|none|none|
|message|string|false|none|none|

