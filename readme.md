# Aster
### A software for cloud folder sync and content encryption.

   Multi-platform, java based program, which monitors a preset folder.
   The files are being encrypted and synced with the NextCloud storage.

   Prerequisites:
   - Java 8
   - Hosted NextCloud (docker run -d -p 8080:80 -v nextcloud:/var/www/html nextcloud)

   _TODO:_
   - Cover send, get, copy of Dav resource
   - set and get resource properties i.e: timestamp and checksum
   - Monitor folder locally
   - Encipher local resources (several block ciphers and password salted key)
   - Fancy UI with many settings

#### Stanislav Zlatinov - LZ2HPC