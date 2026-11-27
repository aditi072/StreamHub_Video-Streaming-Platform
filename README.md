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

Java 21, Spring Boot 4.2, Spring Security + JWT, Spring Data JPA with MySQL 8 (H2 only for automated tests), Kafka, Redis, AWS S3, springdoc (Swagger UI).

## Running locally

1. Install MySQL 8 and create the app user once:
   ```sql
   CREATE USER 'streamhub'@'localhost' IDENTIFIED BY 'streamhub';
   GRANT ALL PRIVILEGES ON streamhub.* TO 'streamhub'@'localhost';
   ```
   The `streamhub` database itself is created on first start.
2. Run the app (the `dev` profile is the default):
   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

Override any connection setting with `DB_URL`, `DB_USERNAME` and `DB_PASSWORD`. In production use `SPRING_PROFILES_ACTIVE=prod`, which also requires `JWT_SECRET`.

## Branches

- `master`: stable, released code
- `develop`: integration branch; features merge here first
- `feature/*`: one branch per piece of work, merged into `develop` through a pull request
