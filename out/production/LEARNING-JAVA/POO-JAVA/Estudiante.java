 device: [\\.\PhysicalDrive0]
03-09 19:56:57:210  INFO: Disk Mode: ST1000DM010-2EP102, Media Type: Fixed hard disk media
03-09 19:56:57:215 ERROR: Filed(1) to DeviceIoControl
(..\..\src\deviceapi\windowsdeviceio.cpp:CWindowsDeviceIo::AnalyzePartition, 392)
03-09 19:56:57:215 ERROR: Get disk Dirve Layout failed.(..\..\src\storagedevice\disk.cpp:CDisk::LoadPartitionsEx, 405)
03-09 19:56:57:215  INFO: Judge Disk Type.
03-09 19:56:57:232 ERROR: partition index 0, type is normal(..\..\src\storagedevice\gpt.cpp:CGpt::EFIGpt2Partition, 150)
03-09 19:56:57:236  INFO: device name /dev/hda1-1048576-523239424
03-09 19:56:57:248  INFO: [CWindowsDeviceIo] : Open device: [\\?\Volume{68e94f2b-a1da-4882-b27d-480193fd4cb2}]
03-09 19:56:57:251 ERROR: Get Drive Letter for volume: \\?\Volume{68e94f2b-a1da-4882-b27d-480193fd4cb2} failed. 
(..\..\src\deviceapi\windowsdeviceio.cpp:CWindowsDeviceIo::Ioctl, 297)
03-09 19:56:57:251 ERROR: Get Drive Letter for volume: \\?\Volume{68e94f2b-a1da-4882-b27d-480193fd4cb2} failed. 
(..\..\src\deviceapi\windowsdeviceio.cpp:CWindowsDeviceIo::Ioctl, 259)
03-09 19:56:57:252 ERROR: partition index 1, type is efi(..\..\src\storagedevice\gpt.cpp:CGpt::EFIGpt2Partition, 122)
03-09 19:56:57:253 ERROR: partition index 2, type is ms reserve(..\..\src\storagedevice\gpt.cpp:CGpt::EFIGpt2Partition, 146)
03-09 19:56:57: