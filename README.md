# file_pass2
  1. 基于之前的file_pass项目，进一步简单学习一下图片流输出和视频流输出。

---

  2. 图片流输出： 是读取本地图片文件流，写入http的response的输出流outputStream

---

  3. 视频流输出：
     http使用request和response，先是request设置好访问文件路径和类型，然后使用config/MediaHttpRequestHandler的handler函数。
     handler（request，response）即可。

## thinking
   1. no thinking, 准备润去看看webpack
   2. 访问图片： http://localhost:8081/getImage
   3. 访问视频： http://localhost:8081/getVideo

## reference
   1. [一文看懂HttpServletResponse](https://www.jianshu.com/p/8bc6b82403c5)
   2. [JAVA输出图片到浏览器](https://blog.csdn.net/qq_16771097/article/details/124386496)
   3. [SpringBoot 视频流和音频流（输出到浏览器）](https://blog.csdn.net/qq_16771097/article/details/124312637?spm=1001.2101.3001.6650.3&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-3-124312637-blog-104806530.pc_relevant_multi_platform_whitelistv1&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-3-124312637-blog-104806530.pc_relevant_multi_platform_whitelistv1&utm_relevant_index=5)
   4. [Spring MVC : ResourceHttpRequestHandler](https://blog.csdn.net/andy_zhang2007/article/details/99545776)
   5. [@Component注解的含义](https://blog.csdn.net/Thinkingcao/article/details/71171222)
   6. [StringUtils.isEmpty is deprecated的原因](https://blog.csdn.net/qq_34626094/article/details/120794627)

