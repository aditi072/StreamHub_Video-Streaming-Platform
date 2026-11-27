# StreamHub - A Video Streaming Platform

A platform where users can upload, process, publish, discover and stream videos. Inspired by YouTube and Netflix, StreamHub aims to provide video content management, seamless video playback, user engagement, personalized recommendations and content analytics.

## Architecture

A **modular monolith**: one Spring Boot application, split into feature packages under `com.streamhub`:

| Package      | Responsibility                                   |
|--------------|--------------------------------------------------|
| `common`     | Shared config, security, error handling          |
| `auth`       | Sign-up, login, JWT                              |
| `user`       | User profiles and channels                       |
| `video`      | Upload, metadata, publishing                     |
| `encoding`   | Background transcoding to HLS (FFmpeg, Kafka)    |
| `catalog`    | Browse and search                                |
| `streaming`  | Playback URLs                                    |
| `engagement` | Likes, comments, views                           |

## Tech stack

Java 21, Spring Boot 4.2, Spring Security + JWT, Spring Data JPA (MySQL, H2 for dev/tests), Kafka, Redis, AWS S3, springdoc (Swagger UI).

## Running locally

```powershell
.\mvnw.cmd spring-boot:run
```

The `dev` profile is the default and uses a local H2 database in `./data`. Use `SPRING_PROFILES_ACTIVE=prod` with `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` and `JWT_SECRET` set for a real MySQL setup.

## Branches

- `master`: stable, released code
- `develop`: integration branch; features merge here first
- `feature/*`: one branch per piece of work, merged into `develop` through a pull request
